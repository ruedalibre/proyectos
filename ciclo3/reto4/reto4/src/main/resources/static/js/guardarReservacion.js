var codigoOrtopedic;
var codigoClient;

function buscarId(ortesis) {

    var selectOrtopedics = document.getElementById("selectOrtopedics").value;
    const idOrt = ortesis.find(ort => ort.name === selectOrtopedics);

    return idOrt.id;

}

function Status() {

    var selectEstatus = document.getElementById("selectStatusRes").value;
    return selectEstatus;

}

function buscarIdClient(clientes) {

    var selectClient = document.getElementById("selectClient").value;
    const idCli = clientes.find(cli => cli.name === selectClient);
    return idCli.idClient;
}

console.log("ejecutando guardar");

function guardarReservacion() {


    $.ajax({
        async: false,
        url: "http://158.101.14.132:8080/api/Ortopedic/all",
        type: 'GET',
        dataType: 'json',
        success: function (respuestaOrtopedic) {
            console.log(respuestaOrtopedic);
            codigoOrtopedic = buscarId(respuestaOrtopedic);
            console.log(codigoOrtopedic);
        },
        error: function (xhr, status) {
            alert('Ha sucedido un problema');
        }
    });

    $.ajax({
        async: false,
        url: "http://158.101.14.132:8080/api/Client/all",
        type: 'GET',
        dataType: 'json',
        success: function (respuestaClient) {
            console.log(respuestaClient);
            codigoClient = buscarIdClient(respuestaClient);
        },
        error: function (xhr, status) {
            alert('Ha sucedido un problema');
        }
    });


    estatus = Status();
    console.log(estatus);
    let reservacion = {
        startDate: $("#startDate").val(),
        devolutionDate: $("#devolutionDate").val(),
        client: {"idClient": codigoClient},
        ortopedic: {"id": codigoOrtopedic},
        score: $("#score").val(),
        status: estatus
    };
    console.log(reservacion);


    $.ajax({
        url: "http://158.101.14.132:8080/api/Reservation/save",
        type: 'POST',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(reservacion),
        statusCode: {
            201: function () {
                alert('Se ha registrado una nueva reservación');
            }

        }

    });


}