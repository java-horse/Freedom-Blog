onload = function() {
    var click_cnt = 0;
    var $html = document.getElementsByTagName("html")[0];
    var $body = document.getElementsByTagName("body")[0];
    $html.onclick = function(e) {
        var $elem = document.createElement("b");
        $elem.style.color = "#E94F06";
        $elem.style.zIndex = 9999;
        $elem.style.position = "absolute";
        $elem.style.select = "none";
        var x = e.pageX;
        var y = e.pageY;
        $elem.style.left = (x - 10) + "px";
        $elem.style.top = (y - 20) + "px";
        clearInterval(anim);
        switch (++click_cnt) {
            case 5:
            case 10:
                $elem.innerText = "OωO";
                break;
            case 15:
            case 20:
                $elem.innerText = "(๑•́ ∀ •̀๑)";
                break;
            case 25:
            case 30:
                $elem.innerText = "(๑•́ ₃ •̀๑)";
                break;
            case 35:
            case 40:
                $elem.innerText = "(๑•̀_•́๑)";
                break;
            case 45:
            case 50:
                $elem.innerText = "（￣へ￣）";
                break;
            case 55:
            case 60:
                $elem.innerText = "(╯°口°)╯(┴—┴";
                break;
            case 65:
            case 70:
                $elem.innerText = "૮( ᵒ̌皿ᵒ̌ )ა";
                break;
            case 75:
            case 80:
                $elem.innerText = "╮(｡>口<｡)╭";
                break;
            case 85:
            case 90:
                $elem.innerText = "( ง ᵒ̌皿ᵒ̌)ง⁼³₌₃";
                break;
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
                $elem.innerText = "(ꐦ°᷄д°᷅)";
                break;
            case 120:
                click_cnt = 0;
                break;
            default:
                // 手动更换下面这行双引号里面的内容 如"😀"
                $elem.innerText = "❤";
                break;
        }
        $elem.style.fontSize = Math.random() * 10 + 8 + "px";
        var increase = 0;
        var anim;
        setTimeout(function() {
            anim = setInterval(function() {
                if (++increase == 150) {
                    clearInterval(anim);
                    $body.removeChild($elem);
                }
                $elem.style.top = y - 20 - increase + "px";
                $elem.style.opacity = (150 - increase) / 120;
            }, 8);
        }, 70);
        $body.appendChild($elem);
    };
};