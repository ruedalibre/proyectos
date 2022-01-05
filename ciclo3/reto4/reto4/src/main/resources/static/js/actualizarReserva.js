function actualizarReserva() {
    console.log("ejecutando actualizar");

    function StatusAct() {
        var selectEstatus = document.getElementById("selectStatusResDet").value;
        return selectEstatus;
    }
    estatus = StatusAct();
    console.log(estatus);

    let reserva = {
        idReservation: +$("#idReservation").val(),
        startDate: $("#startDateDet").val(),
        devolutionDate: $("#devolutionDateDet").val(),
        status: estatus
    };

    console.log(reserva);

    $.ajax({
        url: "http://158.101.14.132:8080/api/Reservation/update",
        type: 'PUT',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(reserva),
        statusCode: {
            201: function () {
                alert('Se ha actualizado los datos de la reserva');
            }
        }
    });


}
