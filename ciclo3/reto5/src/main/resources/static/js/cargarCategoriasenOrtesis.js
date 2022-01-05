function cargarCatenOrt() {
    $.ajax({
        url: "http://158.101.14.132:8080/api/Category/all",
        //url: "http://localhost:8080/api/Category/all",
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
    let idaandCat = [];
    function mostrarRespuesta2(categorias) {
        var select = document.getElementById("select"),
                arr = categorias;
        categoria = {id: "", name: "", description: "", ortopedics: ""};
        const keys = Object.keys(categoria);

        arr.forEach((Element) => {
            console.log(Element.name);
            var option = document.createElement("OPTION"),
                    txt = document.createTextNode(Element.name);
            ids.push(Element.id);
            console.log(idaandCat);
            option.appendChild(txt);
            select.insertBefore(option, select.lastChild);
            console.log(ids);
        });
    }
}