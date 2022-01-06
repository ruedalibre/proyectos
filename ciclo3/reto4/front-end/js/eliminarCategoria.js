function eliminarCategoria(identificador) {

    let category = {
        id: +identificador
    };

    console.log(identificador);


    $.ajax({
        url: "http://158.101.14.132:8080/api/Category/get/" + identificador,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            console.log(respuesta.ortopedics.length);
            if (respuesta.ortopedics.length > 0) {
                alert('La categoría contiene ortesis. No se puede eliminar');
            } else {
                $.ajax({
                    url: "http://158.101.14.132:8080/api/Category/" + identificador,
                    type: 'DELETE',
                    dataType: 'json',
                    headers: {
                        "Content-Type": "application/json"
                    },
                    data: JSON.stringify(category),
                    statusCode: {
                        204: function () {
                            alert('Se ha eliminado la categoria');
                            consultarCategoria();
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