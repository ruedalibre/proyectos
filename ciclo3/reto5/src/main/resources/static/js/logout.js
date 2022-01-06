function logout(ortesis) {
    var logout = function () {
        $.post("/logout", function () {
            $("#user").html('');
            $(".unauthenticated").show();
            $(".authenticated").hide();
        });
        return true;
    };
}
