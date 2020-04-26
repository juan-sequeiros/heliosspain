import logging
import pandas as pd
from csv import writer
import argparse


def predict(weights, instance):
    y_ = 0
    i = 0

    for att_i in instance:
        if i is not 0:
            y_ += weights[i] * att_i
        i += 1
    logging.info(f"y predicted: {y_} for patient: {instance[0]}")
    return y_

def pre_process(instance_):
    i = 0
    instance = instance_.copy()
    for item in instance_:
        # Si ha estado en mas de 1 hospital
        if i == 1:
            if item > 5:
                instance[i] = 1
            elif 5 >= item >= 3:
                instance[i] = 0.75
            elif 3 > item > 1:
                instance[i] = 0.5
            else:
                instance[i] = 0.2
        # Numero de pacientes con los que ha estado en contacto.
        elif i == 2:
            if 0 < item < 50:
                instance[i] = 0.1
            elif 50 <= item < 150:
                instance[i] = 0.3
            elif 150 <= item < 250:
                instance[i] = 0.5
            elif 250 <= item < 350:
                instance[i] = 0.75
            else:
                instance[i] = 1
        else:
            instance[i] = item
        i += 1

    return instance


def read_dataset(path_file):
    dataset = pd.read_csv(path_file, delimiter=',', header=None)
    dataset = dataset.values.tolist()
    return dataset


def parse_arguments():
    parser = argparse.ArgumentParser(description="Run Helios python model. -f data file path")
    parser.add_argument("-f", "--file", type=str, help="filename")
    args = parser.parse_args()
    return args


def save_to_csv(path_results, row):
    with open(path_results, 'a+', newline='') as write_obj:
        csv_writer = writer(write_obj)
        csv_writer.writerow(row)


if __name__ == '__main__':
    """
    1. Si ha estado en mas de 1 hospital
    2. Numero de pacientes con el que ha estado en contacto * 2%/ [Entre 200-100: 1, 100-75: 0.7, 50-75: 0.5]
    3. Ha estado en quirofano? w = 0.1
    4. Ha estado en una sala de espera? w = 0.5
    75121583H, 3, 580, 1, 1, XXX 

    """
    logging.basicConfig(format='%(name)s - %(levelname)s - (%(funcName)s) -> %(message)s', level=logging.DEBUG)

    weights = ['-', 0.2, 0.5, 0.1, 0.2]

    args = parse_arguments()
    path_file = args.file
    logging.debug(f"Path file: {path_file}")
    # path_file = '/Users/eva/Desktop/data.csv'
    path_results = '/Users/eva/Desktop/res.csv'
    dataset = read_dataset(path_file)
    logging.debug(f"dataset: {dataset}")

    for instance_ in dataset:
        logging.debug(f"Instance: {instance_}")
        instance = pre_process(instance_)
        logging.info(f"Pre processed instance{instance}")
        y_ = predict(weights, instance)
        save_to_csv(path_results, [instance[0], y_])
