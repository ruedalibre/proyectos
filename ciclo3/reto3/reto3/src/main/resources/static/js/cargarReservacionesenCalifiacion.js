//Carga las ortesis en el menú desplegable de reservaciones
function cargarReservacionesenCalificacion() {
    $.ajax({
        url: "http://158.101.14.132:8080/api/Reservation/all",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            mostrarRespuesta2(respuesta);

        },
        error: function (xhr, status) {
            alert('Ha sucedido un problema');
        }
    });

    let ids = [];
    let idandName = [];
    function mostrarRespuesta2(reserva) {
        var select = document.getElementById("selectReservas"),
            arr = reserva;
        res = { idReservation: "", startDate: "", devolutionDate: "", status: "", ortopedic: "", client: "", score: "" };
        const keys = Object.keys(res);

        arr.forEach((Element) => {
            var option = document.createElement("OPTION"),
                txt = document.createTextNode(Element.idReservation);
            ids.push(Element.idReservation);
            option.appendChild(txt);
            select.insertBefore(option, select.lastChild);
        });
    }
}