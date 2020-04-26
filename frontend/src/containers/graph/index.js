import React, { useEffect } from "react";
import CytoscapeComponent from 'react-cytoscapejs';
import {
    Content,
} from "carbon-components-react/lib/components/UIShell";


const Graph = ({ onSelectNode, nodes = [] }) => {
    let cyRef = React.createRef();

    const layout = {
        name: 'random',
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
                            'background-color': '#e0e0e0',
                            'label': function backgroundImage(node) {
                                let text = node.data().name ? node.data().name : "";
                                return `${text}`;
                            },

                        }
                    },
                    {
                        selector: 'node[type = "doctor"]',
                        style: {
                            'background-color': '#0f62fe',

                        }
                    },
                    {
                        selector: 'node[type = "nurse"]',
                        style: {
                            'background-color': '#78a9ff',
                        }
                    },
                    {
                        selector: 'node[type = "patient"]',
                        style: {
                            'background-color': '#e0e0e0',
                        }
                    },
                    {
                        selector: 'node[covid19 > 9]',
                        style: {
                            'border-width': 2,
                            'border-color': '#ba1b23',
                            "color": "red",
                            'label': function backgroundImage(node) {
                                return `${node.data().name} covid-19`;
                            },
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