$(document).ready(function () {
    console.log("document ready!");
    let searchParams = new URLSearchParams(window.location.search);
    if (searchParams.has('id')) {
        let id = searchParams.get('id');
        consultarById(id);
        console.log(id);
    }
});

function consultarById(id) {
    $.ajax({
        url: "http://158.101.14.132:8080/api/Reservation/get/" + id,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            llenarDatos(respuesta);

        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}


function llenarDatos(item) {

    $("#idReservation").val(item.idReservation);
    $("#selectStatusResDet").val(item.status);
    $("#ortopedicDet").val(item.ortopedic.name);
    $("#clientDet").val(item.client.name);

}
