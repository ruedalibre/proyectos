var codigoReserva;

function buscarIdReserva(reservas) {

    var selectReservas = document.getElementById("selectReservas").value;
    return selectReservas;

}

function guardarCalificacion() {

    $.ajax({
        async: false,
        url: "http://158.101.14.132:8080/api/Reservation/all",
        //url: "http://localhost:8080/api/Reservation/all",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            codigoReserva = buscarIdReserva(respuesta);
            console.log(codigoReserva);
        },
        error: function (xhr, status) {
            alert('Ha sucedido un problema');
        }
    });


    let calificacion = {
        score: $("#score").val(),
        message: $("#message").val(),
        idReserva: codigoReserva
    };
    console.log(calificacion);


    $.ajax({
        url: "http://158.101.14.132:8080/api/Score/save",
        //url: "http://localhost:8080/api/Score/save",
        type: 'POST',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(calificacion),
        statusCode: {
            201: function () {
                alert('Se ha registrado una nueva calificación');
            }
        }
    });


}