function cargarOrtesisEnMensaje() {
    $.ajax({
        url: "http://158.101.14.132:8080/api/Ortopedic/all",
        //url: "http://localhost:8080/api/Ortopedic/all",
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
    function mostrarRespuesta2(ortesis) {
        var select = document.getElementById("selectOrtopedics"),
                arr = ortesis;
        ort = {id: "", name: "", brand: "", year: "", description: ""};
        const keys = Object.keys(ort);

        arr.forEach((Element) => {
            var option = document.createElement("OPTION"),
                    txt = document.createTextNode(Element.name);
            ids.push(Element.id);
            option.appendChild(txt);
            select.insertBefore(option, select.lastChild);
        });
    }
}