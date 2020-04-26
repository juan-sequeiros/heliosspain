export default [
    {
        "data": {
            "id": "doctor-1", // Id unico del paciente
            "name": "David", // datos
            "surname": "Martín García",// datos
            "type": "doctor", // Importante rol o tipo lo que querais
            "typeDescription": "Doctor", // Descripcion del rol o tipo
            "specialty": "Medicina general", //Mas datos
            "covid19": 10, // mas datos
        },
        "position": {
            "x": 300.5, // Position x de la bola en el grafo
            "y": 20.7372431003224 // Position y de la bola en el grafo
        },
        "group": "nodes", // Dejarlo asi BOLA
        "removed": false,// Cosas de front
        "selected": false,// Cosas de front
        "selectable": true,// Cosas de front
        "locked": false,// Cosas de front
        "grabbable": true,// Cosas de front
        "classes": ""// Cosas de front
    },
    {
        "data": {
            "id": "paciente-2", // Id unico del paciente
            "name": "Carmen", // datos
            "surname": "Martín García", // datos
            "type": "enfermera", // Importante rol o tipo lo que querais
            "typeDescription": "Enfermera", // Descripcion del rol o tipo
            "specialty": "Medicina general", //Mas datos
            "covid19": 10 // mas datos
        },
        "position": {
            "x": 670.4301869950953, // Position x de la bola en el grafo
            "y": 229.70989985711336 // Position y de la bola en el grafo
        },
        "group": "nodes", // Dejarlo asi BOLA
        "removed": false,// Cosas de front
        "selected": false,// Cosas de front
        "selectable": true,// Cosas de front
        "locked": false,// Cosas de front
        "grabbable": true,// Cosas de front
        "classes": ""// Cosas de front
    },
    {
        "data": {
            "id": "connect-d1-p2", // ID unico del enlace
            "source": "doctor-1", // De donde va a venir el enlace
            "cited": 1, // Dejarlo asi
            "target": "paciente-2", // Target del enlace 
            "isdirected": true, // Dejarlo asi
        },
        "position": {}, // Como es enlace nada 
        "group": "edges", // Dejarlo asi ENLACE
        "removed": false, // Cosas de front
        "selected": false, // Cosas de front
        "selectable": true, // Cosas de front
        "locked": false, // Cosas de front
        "grabbable": true, // Cosas de front
        "classes": "" // Cosas de front
    },
]