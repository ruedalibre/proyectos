function eliminar(identificador) {

    let orthesis = {
        id: +identificador
    };

    console.log(orthesis);

    $.ajax({
        url: "http://158.101.14.132:8080/admin/orthesis/orthesis",
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