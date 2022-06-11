
  function enviar(){
        console.log("teste");
               var inputNome = document.querySelector("#name");
               var name = inputNome.value;
               var inputSenha = document.querySelector("#senha");
               var senha = inputSenha.value;
               var email = document.querySelector("#email").value;
               console.log("teste");

               console.log(name, senha, email);
               $.ajax({
                 url : "/cadastro/adicionar",
                 type : 'post',
                 data : {
                      nome : name,
                      senha: senha,
                      email: email
                 },

            })
            .done(function(json){
                 $("#resultado").html(json);
                 window.location.replace("http://localhost:8080/login.html");
            })
            .fail(function(jqXHR, textStatus, msg){
                 alert("deu ruim");
            });
            }

function logar(){
               var senha = document.querySelector("#senha").value;
               var email = document.querySelector("#email").value;

               $.ajax({
                 url : "login/logar",
                 type : 'post',
                 data : {
                      email: email,
                      senha: senha
                 },

            })
             .done(function(msg){
                 console.log(msg);
                 if(msg == true){
                  window.location.replace("http://localhost:8080/home.html");
                 }else{
                    alert("falha de login, senha ou email inválidos");
                 }

            })
            .fail(function(jqXHR, textStatus, msg){
                 alert("falha de login");
            });
            }
function teste(){

               $.ajax({
                 url : "home/listar",
                 type : 'get',

            })
             .done(function(json){
                  showClientes(json)
            })
            .fail(function(jqXHR, textStatus, msg){
                 alert("deu ruim");
            });


}

function showClientes(json){
    var tbody = document.querySelector("#tbody");

    for(const i in json){
        var linha = document.createElement("tr");

        var colNome = document.createElement('td');
        var colEmail = document.createElement('td');
        var colButtonExcluir = document.createElement('td');
        var colButtonEditar = document.createElement('td');

        var buttonEditar = document.createElement('button');
        var buttonExcluir = document.createElement('button');

        colNome.textContent = json[i]["nome"];
        colEmail.textContent = json[i]["email"];

        buttonExcluir.textContent = "Excluir";
        buttonEditar.textContent = "Editar";

        id = json[i]["id"];
        nome = json[i]["id"];
        email = json[i]["id"];
        senha = json[i]["id"];

        buttonExcluir.setAttribute("onclick", "excluir("+id+")");
        buttonEditar.setAttribute("onclick", "editar("+id+")");
        buttonEditar.classList.add('btn', "btn-primary");
        buttonExcluir.classList.add('btn', "btn-danger");

        colButtonExcluir.appendChild(buttonExcluir)
        colButtonEditar.appendChild(buttonEditar)

        linha.appendChild(colNome);
        linha.appendChild(colEmail);
        linha.appendChild(colButtonEditar);
        linha.appendChild(colButtonExcluir);
        tbody.appendChild(linha);
    }

}

function excluir(id){
            $.ajax({
                 url : "home/excluir/"+id,
                 type : 'delete',

            })
             .done(function(msg){
                   alert("excluido");
            })
            .fail(function(jqXHR, textStatus, msg){
                 alert("deu ruim");
            });

}

function editar(id){
            var form = document.querySelector(".formulario");
            var button = document.querySelector("#button");
            form.style.display = "block";
            button.setAttribute("onclick", "formEditar("+id+")")

}

function formEditar(id){
         var senha = document.querySelector("#senha").value;
         var email = document.querySelector("#email").value;
         var nome = document.querySelector("#name").value;

                     $.ajax({
                          url : "home/editar",
                          type : 'put',
                          data : {
                                   id: id,
                                   nome: nome,
                                   email: email,
                                   senha: senha
                                },

                     })
                      .done(function(msg){
                            alert("editado com sucesso");
                     })
                     .fail(function(jqXHR, textStatus, msg){
                          alert("deu ruim");
                     });
}