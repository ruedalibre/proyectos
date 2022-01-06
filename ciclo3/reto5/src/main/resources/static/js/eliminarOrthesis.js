function eliminarOrthesis(identificador) {

    let orthesis = {
        id: +identificador
    };

    console.log(identificador);

    $.ajax({
        url: "http://158.101.14.132:8080/api/Ortopedic/get/" + identificador,
        //url: "http://localhost:8080/api/Ortopedic/get/" + identificador,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            if (respuesta.messages.length > 0 || respuesta.reservations.length > 0) {
                alert('La ortesis contiene mensajes o reservas. No se puede eliminar');
            } else {
                $.ajax({
                    url: "http://158.101.14.132:8080/api/Ortopedic/" + identificador,
                    //url: "http://localhost:8080/api/Ortopedic/" + identificador,
                    type: 'DELETE',
                    dataType: 'json',
                    headers: {
                        "Content-Type": "application/json"
                    },
                    data: JSON.stringify(orthesis),
                    statusCode: {
                        204: function () {
                            alert('Se ha eliminado la orthesis');
                            consultarOrthesis();
                        }
                    }
                });
            }
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });


}