import React, { useEffect } from "react";
import CytoscapeComponent from 'react-cytoscapejs';
import {
    Content,
} from "carbon-components-react/lib/components/UIShell";
import userSvg from "@fortawesome/fontawesome-free/svgs/solid/user-md.svg"


const Graph = ({ onSelectNode, nodes = [] }) => {
    let cyRef = React.createRef();

    const layout = {
        name: 'concentric',
        concentric: function (node) {
            return node.degree();
        },
        levelWidth: function (nodes) {
            return 2;
        }
    };

    useEffect(() => {
        if (cyRef) {
            cyRef.on('click', 'node', function (evt) {
                onSelectNode(this.data());
            });
        }
    }, [cyRef, onSelectNode])

    return (
        <Content id="main-content">
            <CytoscapeComponent
                elements={nodes}
                cy={(cy) => {
                    cy.on('add', 'node', _evt => {
                        cy.layout(layout).run();
                        cy.fit();
                    })
                    cyRef = cy
                }}
                style={{ width: '100%', height: '100%' }}
                stylesheet={[
                    {
                        selector: 'node',
                        style: {
                            'background-color': '#30c9bc',
                        }
                    },
                    {
                        selector: 'node[type = "doctor"]',
                        style: {
                            'background-color': '#0f62fe',
                        }
                    },
                    {
                        selector: 'node[type = "enfermera"]',
                        style: {
                            'background-color': '#78a9ff',
                        }
                    },
                    {
                        selector: 'node[type = "paciente"]',
                        style: {
                            'background-color': '#525252',
                        }
                    },
                    {
                        selector: 'node[covid19 > 20]',
                        style: {
                            'border-width': 2,
                            'border-color': '#ba1b23'
                        }
                    },
                    {
                        selector: 'node[!covid19]',
                        style: {
                            'border-width': 2,
                            'border-color': '#4c4c4c'
                        }
                    },
                    {
                        selector: 'edge',
                        style: {
                            'curve-style': 'haystack',
                            'haystack-radius': 0,
                            'width': 5,
                            'opacity': 0.5,
                            'line-color': '#a8eae5'
                        }
                    }
                ]}
            />;
        </Content>
    );
}

export default Graph;