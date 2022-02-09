function calcPrecioConDcto (priceValue, descuentoNormal, descuento) {
    const porcPrecioConDcto = 100 - descuentoNormal - descuento;
    const precioConDcto = (priceValue * porcPrecioConDcto) / 100;
    return precioConDcto;
}

/* const coupons = [
    "golden", 
    "silver", 
    "bronze"
];
*/

const coupons = [ 
    {
        name: "golden",
        discount: 25,
    },

    {
        name: "silver", 
        discount: 15,
    },

    {
        name: "bronze",
        discount: 15,
    },
];

function onClickPriceDiscount () {
    /* De esta manera accedo al input con el id del precio... */
    const inputPrice = document.getElementById("InputPrice");
     /* ...y accedo a su valor */ 
    const priceValue = inputPrice.value;
    /* Lo mismo para el descuento y el cupón */
    const inputDiscount = document.getElementById("InputDiscount");
    const discountValue = inputDiscount.value;

    const inputCoupon = document.getElementById("InputCoupon");
    const couponValue = inputCoupon.value;

    // let descuento; 

    /* switch(couponValue) {
        case coupons[0]: 
            descuento = 25;
        break;

        case coupons[1]:
            descuento = 15;
        break;

        case coupons[2]:
            descuento = 10;
        break;
    }
    */
    const coupons = [
        {
            name: "golden",
            discount: 25,
        }, 
        {
            name: "silver",
            discount: 15,
        }, 
        {
            name: "bronze",
            discount: 10,
        } 
    ];

    /* if(!coupons.includes(couponValue)) {
        alert("This coupon " + couponValue + " is not valid!");
    } else if(couponValue === "golden") {
        descuento = 25;
    } else if(couponValue === "silver") {
        descuento = 15;
    } else if(couponValue === "bronze") {
        descuento = 10;
    }
    */
    
    const descuentoNormal = discountValue;

    const isCouponValueValid = function (coupon) {
        return coupon.name === couponValue;
    };
    
    const userCoupon = coupons.find(isCouponValueValid);
    
    if (!userCoupon) {
        alert("This coupon " + userCoupon + "is not valid!");
    } else {
        const descuento = userCoupon.discount;
        const precioConDcto = calcPrecioConDcto(priceValue, descuentoNormal, descuento);

        const result = document.getElementById("Result");
        result.innerText = "Price of the product after discounts: $ " 
        + precioConDcto;
    }

    /* Después de crear las variables que guardan el valor 
    ingresado por el usuario, llamo nuevamente la función 
    que calcula el descuento pero le paso los parámetros anteriores
    de precio y descuento*/
    // const precioConDcto = calcPrecioConDcto(priceValue, descuento);

    /* AQUÍ CONECTO EL ID DEL PÁRRAFO DONDE VOY A MOSTRAR EL 
    RESULTADO CON UNA VARIABLE QUE GUARDA EL RESULTADO DE LA
    OPERACIÓN MATEMÁTICA QUE CALCULA EL DESCUENTO */
    // const result = document.getElementById("Result");
   
    /* El mensaje para el usuario (+ el resultado de la operación) 
    se muestra gracias al método innerText */
    // result.innerText = "Price of the product after discount: $" + precioConDcto;
}