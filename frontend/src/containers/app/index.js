import React, { useState } from "react";
import Graph from "../graph";
import HeaderApp from "../header";
import Sidebar from "../sidebar";
import "./styles.scss";
import elements from "./data";

async function postData(url = '', data = {}) {
    const response = await fetch(url, {
        method: 'POST',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json'
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(data)
    });
    return response.json();
}

const App = () => {

    const [selectedNode, setSelectedNode] = useState(null);
    const [nodes, setNodes] = useState([]);

    const onSelectNode = (node) => {
        setSelectedNode(node);
    }

    const onFetchData = () => {
        // Mock
        // setNodes(elements);

        //postData('http://35.228.138.176:8080/heliosspain-against/mocks', {})
        //postData('http://localhost:4556/fetch', {})
        postData('http://35.228.138.176:8080/heliosspain-against/getAllDataHospital', {})
            .then((nodes) => {
                nodes = nodes.map((node) => {
                    if (node.data && (node.data.type === "nurse" || node.data.type === "patient")) {
                        var rnd = Math.random();
                        if (rnd < 0.6) {
                            node.data.type = "patient";
                        } else {
                            node.data.type = "nurse";
                        }
                    }
                    return node;
                })
                setNodes(nodes);
                //setNodes(elements);
            }).catch(() => {
                setNodes(elements);
            });
    }

    return (
        <div className="container">
            <HeaderApp selectedNode={selectedNode} />
            <React.Fragment>
                <Sidebar fetchData={onFetchData} />
                <Graph onSelectNode={onSelectNode} nodes={nodes} />
            </React.Fragment>
        </div>
    )
}

export default App;