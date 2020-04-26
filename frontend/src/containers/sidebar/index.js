import React from "react";
import {
    SideNav,
    Form,
    FormGroup,
    Select,
    SelectItem,
    Button,
    DatePicker,
    DatePickerInput
} from "carbon-components-react";
import ueSvg from "./ue.svg";
import "./style.scss";

const paises = [
    "Alemania",
    "Austria",
    "Bélgica",
    "Bulgaria",
    "Chequia",
    "Chipre",
    "Croacia",
    "Dinamarca",
    "Eslovaquia",
    "Eslovenia",
    "España",
    "Estonia",
    "Finlandia",
    "Francia",
    "Grecia",
    "Hungría",
    "Irlanda",
    "Italia",
    "Letonia",
    "Lituania",
    "Luxemburgo",
    "Malta",
    "Países Bajos",
    "Polonia",
    "Portugal",
    "Rumanía",
    "Suecia"
];

const hospitals = Array.from({ length: 10 }, (key, i) => "Hostpital " + i);

const Sidebar = ({ fetchData }) => {

    const getData = (event) => {
        event.preventDefault();
        const target = event.target;
        const data = {
            hospital: target.hospital.value,
            pais: target.pais.value,
            startDate: target.startDate.value,
            endDate: target.endDate.value
        }
        fetchData(data);

    }

    return (
        <SideNav
            isFixedNav
            expanded={true}
            isChildOfHeader={false}
            aria-label="Side navigation"
        >
            <div className="execution">
                <div className="execution__main">
                    <h2>Searcher</h2>
                    <img alt="eu" src={ueSvg} />
                </div>
                <div className="execution__hr" />
                <p className="execution__info">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien augue, ultrices sit amet mi a, pellentesque tincidunt ex. Quisque facilisis, metus id mollis rhoncus.
                </p>
                <Form onSubmit={getData}>
                    <FormGroup>
                        <Select
                            id="pais"
                            name="pais"
                            invalidText="This is an invalid error message."
                            labelText="Countries:"
                        >
                            {paises.map((pais) => {
                                return (<SelectItem
                                    key={pais}
                                    text={pais}
                                    value={pais}
                                />);
                            })}
                        </Select>
                    </FormGroup>
                    <FormGroup>
                        <Select
                            defaultValue="placeholder-item"
                            id="hospital"
                            name="hospital"
                            invalidText="This is an invalid error message."
                            labelText="Hospitals:"
                        >
                            {hospitals.map((hospital) => {
                                return (<SelectItem
                                    key={hospital}
                                    text={hospital}
                                    value={hospital}
                                />);
                            })}
                        </Select>
                    </FormGroup>
                    <FormGroup>
                        <DatePicker dateFormat="d/m/Y" datePickerType="range" >
                            <DatePickerInput
                                id="date-picker-range-start"
                                name="startDate"
                                placeholder="dd/mm/yyyy"
                                labelText="Start date:"
                                type="text"
                            />
                            <DatePickerInput
                                id="date-picker-range-end"
                                name="endDate"
                                placeholder="dd/mm/yyyy"
                                labelText="End date:"
                                type="text"
                            />
                        </DatePicker>
                    </FormGroup>
                    <Button
                        kind="primary"
                        tabIndex={0}
                        type="submit"
                    >
                        Execution
                    </Button>
                </Form>
            </div>
        </SideNav>
    );
}

export default Sidebar;