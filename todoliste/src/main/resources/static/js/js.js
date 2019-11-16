// checks the values of two password if they are the same
function same(){
    var p1 = document.getElementById("password1");
    var p2 = document.getElementById("password2");
    var s1 = document.getElementById("passChange");
    if(s1== null){
         s1 = document.getElementById("reg");
    }
    var text = document.getElementById("help");
    if(p1.value===p2.value){
        s1.classList.remove("hidden");
        text.classList.add("hidden");
    } else {
        s1.classList.add("hidden");
        text.classList.add("wrong");
        text.classList.remove("hidden");
    }
}