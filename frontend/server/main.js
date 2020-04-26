const neo4j = require('neo4j-driver')
var express = require('express');
const bodyParser = require('body-parser');
var cors = require('cors')
var parser = require('parse-neo4j');
var app = express();
const uri = "bolt://35.228.138.176:7687";
const user = "neo4j";
const password = "helios";
app.use(bodyParser.json());
app.use(cors())

const driver = neo4j.driver(uri, neo4j.auth.basic(user, password))
const session = driver.session()
const personName = 'Alice'

async function connect() {
    try {
        const result = await session.run(
            {
                "statements": [{
                    "statement": "MATCH p=()-->() RETURN p LIMIT 25",
                    "resultDataContents": ["graph"],
                    "includeStats": true
                }]
            },
            { name: personName }
        )

        const singleRecord = result.records[0]
        const node = singleRecord.get(0)

        console.log(JSON.stringify(result))
    } finally {
        await session.close()
    }

    // on application exit:
    await driver.close()
}

async function getQuery(query) {
    try {
        const result = await session.run(query,
            { name: personName }
        )

        const singleRecord = result.records[0]
        const node = singleRecord.get(0)
        console.log(JSON.stringify(result))

        return result;
    } finally {
        await session.close()
    }
}
/*
function node() {
    return {
        "data": {
            "id": "paciente-2",
            "name": "Carmen",
            "surname": "Martín García",
            "type": "enfermera",
            "typeDescription": "Enfermera",
            "specialty": "Medicina general",
            "covid19": 10
        },
        "position": {
            "x": 670.4301869950953,
            "y": 229.70989985711336
        },
        "group": "nodes",
        "removed": false,
        "selected": false,
        "selectable": true,
        "locked": false,
        "grabbable": true,
        "classes": ""
    };
}

function edge() {
    return {
        "data": {
            "id": "connect-d1-p2",
            "source": "doctor-1",
            "cited": 1,
            "target": "paciente-2",
            "isdirected": true,
        },
        "position": {},
        "group": "edges",
        "removed": false,
        "selected": false,
        "selectable": true,
        "locked": false,
        "grabbable": true,
        "classes": ""
    };
}
*/

function proxy(data4J) {
    return data4J.records.map((element) => {
        element[0]._fields
    });
}

app.get('/fetch', function (req, res) {
    getQuery("MATCH p=()-->() RETURN p LIMIT 25").then(parser.parse).then((data) => {
        console.log(data);
        res.json(data);
    });
})



app.post('/fetch', function (req, res) {
    getQuery("MATCH p=()-->() RETURN p LIMIT 25").then(parser.parse).then((data) => {
        console.log(data);
        res.json(data);
    });
})


//connect();

app.listen(4556, () => {
    console.log("OK")
});
