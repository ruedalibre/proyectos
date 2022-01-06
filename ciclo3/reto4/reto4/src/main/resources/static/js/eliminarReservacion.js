function eliminarReservacion(identificador) {

    $.ajax({
        url: "http://158.101.14.132:8080/api/Reservation/" + identificador,
        type: 'DELETE',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(identificador),
        statusCode: {
            204: function () {
                alert('Se ha eliminado la reserva');
                consultarReservaciones();
            }
        }
    });

}
