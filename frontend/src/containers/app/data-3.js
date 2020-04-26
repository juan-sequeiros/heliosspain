export default [
    {
        "data": {
            "id": "doctor-1", 
            "name": "David", 
            "surname": "Martín García",
            "type": "doctor", 
            "typeDescription": "Doctor", 
            "specialty": "Medicina general", 
            "covid19": 10 
        },
        "position": {
            "x": 539.5, 
            "y": 641.7372431003224 
        },
        "group": "nodes", 
        "removed": false,
        "selected": false,
        "selectable": true,
        "locked": false,
        "grabbable": true,
        "classes": ""
    },
    {
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
    },
    {
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
    },
]