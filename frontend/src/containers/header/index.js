import React, { useState, useEffect } from "react";
import {
    Header,
    HeaderName,
    HeaderGlobalAction,
    HeaderGlobalBar,
    HeaderPanel,
    StructuredListWrapper,
    StructuredListHead,
    StructuredListBody,
    StructuredListRow,
    StructuredListCell,
} from "carbon-components-react";
import Notification20 from "@carbon/icons-react/lib/notification/20";
import AppSwitcher20 from "@carbon/icons-react/lib/app-switcher/20";
import "./style.scss";

const HeaderApp = ({ selectedNode }) => {

    const [expanded, setExpanded] = useState(true);

    let icon = "fas fa-user";

    if (selectedNode) {
        switch (selectedNode.type) {
            case "doctor":
                icon = "fas fa-user-md";
                break;
            case "nurse":
                icon = "fas fa-nurse";
                break;
            default:
                icon = "fas fa-user";
        }
    }

    useEffect(() => {
        if (selectedNode) {
            setExpanded(true);
        }
    }, [selectedNode]);

    return (
        <Header aria-label="IBM Platform Name">
            <HeaderName href="#" prefix="HeliosSpain">
                [Against]
            </HeaderName>
            <HeaderGlobalBar>
                <HeaderGlobalAction aria-label="Notifications" onClick={() => { }}>
                    <Notification20 />
                </HeaderGlobalAction>
                <HeaderGlobalAction aria-label="App Switcher" onClick={() => { setExpanded(!expanded) }}>
                    <AppSwitcher20 />
                </HeaderGlobalAction>
            </HeaderGlobalBar>
            <HeaderPanel expanded={selectedNode && expanded}>
                {selectedNode ? (
                    <div className="info">
                        <div className="info__main">
                            <div className="info__name">
                                <i className={icon} />
                                <h2>{selectedNode.name}</h2>
                            </div>
                            <span className="info__surname">{selectedNode.surname}</span>
                        </div>
                        <div className="info__hr" />
                        <h4>Information</h4>
                        <div className="info__element">
                            <fieldset className="bx--fieldset">
                                <legend className="bx--label">Type:</legend>
                                <span>{selectedNode.type}</span>
                            </fieldset>
                        </div>
                        <div className="info__element">
                            <fieldset className="bx--fieldset">
                                <legend className="bx--label">Medical specialty:</legend>
                                <span>{selectedNode.specialty}</span>
                            </fieldset>
                        </div>
                        <div className="info__element">
                            <fieldset className="bx--fieldset">
                                <legend className="bx--label">COVID-19 analysis:</legend>
                                <span>Analizado</span>
                            </fieldset>
                        </div>
                        <div className="info__element">
                            <fieldset className="bx--fieldset">
                                <legend className="bx--label">Calendar:</legend>
                                <StructuredListWrapper>
                                    <StructuredListHead>
                                        <StructuredListRow head>
                                            <StructuredListCell head>Start</StructuredListCell>
                                            <StructuredListCell head>End</StructuredListCell>
                                            <StructuredListCell head>Ocupacion</StructuredListCell>
                                        </StructuredListRow>
                                    </StructuredListHead>
                                    <StructuredListBody>
                                        <StructuredListRow>
                                            <StructuredListCell noWrap>10:00</StructuredListCell>
                                            <StructuredListCell>11:00</StructuredListCell>
                                            <StructuredListCell>
                                                Emergency
                                            </StructuredListCell>
                                        </StructuredListRow>
                                        <StructuredListRow>
                                            <StructuredListCell noWrap>11:00</StructuredListCell>
                                            <StructuredListCell>12:00</StructuredListCell>
                                            <StructuredListCell>
                                                Emergency
                                            </StructuredListCell>
                                        </StructuredListRow>
                                    </StructuredListBody>
                                </StructuredListWrapper>
                            </fieldset>
                        </div>
                    </div>
                ) : <div className="info">
                        <div className="info__select">
                            <h2>Select node</h2>
                        </div>
                    </div>}
            </HeaderPanel>
        </Header>
    );
}

export default HeaderApp;