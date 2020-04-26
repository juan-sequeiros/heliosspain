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
    "All",
    "Austria",
    "Belgium",
    "Bulgaria",
    "Cyprus",
    "Czech Republic",
    "Denmark",
    "Estonia",
    "Finland",
    "France",
    "Germany",
    "Greece",
    "Hungary",
    "Ireland",
    "Italy",
    "Latvia",
    "Lithuania",
    "Luxembourg",
    "Malta",
    "Netherlands",
    "Poland",
    "Portugal",
    "Romania",
    "Slovakia",
    "Slovenia",
    "Spain",
    "Sweden",
    "United Kingdom",

];
let hospitals = []
hospitals.push("All");
hospitals = hospitals.concat(Array.from({ length: 10 }, (key, i) => "Hostpital " + i));

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

                </p>
                <Form onSubmit={getData}>
                    <FormGroup>
                        <Select
                            id="pais"
                            name="pais"
                            invalidText="This is an invalid error message."
                            labelText="Countries:"
                            defaultValue="All"
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
                            value="All"
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