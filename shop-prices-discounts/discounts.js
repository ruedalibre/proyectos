// const precioOriginal = 170.6; 
// const descuento = 17;

// console.log({
//     precioOriginal,
//     descuento,
//     porcPrecioConDcto,
//     precioConDcto 
    
// });

function calcPrecioConDcto (precio, dcto) {
    const porcPrecioConDcto = 100 - dcto;
    const precioConDcto = (precio * porcPrecioConDcto) / 100;

    return precioConDcto;

}

function onClickPriceDiscount () {
    /* De esta manera accedo al input con el id indicado... */
    const inputPrice = document.getElementById("InputPrice");
     /* ...pero necesito además acceder a su valor */ 
    const priceValue = inputPrice.value;

    const inputDiscount = document.getElementById("InputDiscount");
    const discountValue = inputDiscount.value;

    /* Después de crear las variables que guardan el valor 
    ingresado por el usuario, llamo nuevamente la función 
    que calcula el descuento pero le paso los parámetros anteriores
    de precio y descuento*/
    const precioConDcto = calcPrecioConDcto(priceValue, discountValue);

    /* AQUÍ CONECTO EL ID DEL PÁRRAFO DONDE VOY A MOSTRAR EL 
    RESULTADO CON UNA VARIABLE QUE GUARDA EL RESULTOADO DE LA
    OPERACIÓN MATEMÁTICA QUE CALCULA EL DESCUENTO */
    const resultP = document.getElementById("ResultP");
    /* El mensaje para el usuario (+ el resultado de la operación) 
    se muestra gracias al método innerText */
    resultP.innerText = "Price of the product after discount: $" + precioConDcto;

}



