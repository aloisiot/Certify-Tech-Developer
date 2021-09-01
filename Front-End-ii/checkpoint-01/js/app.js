document.getElementById("submit-button").addEventListener( 'click',
    (event) => {

        event.preventDefault();

        let url = document.getElementById("url-input").value;

        if(url != ""){
            document.body.style.backgroundImage = `url('${url}')`;
    }

})