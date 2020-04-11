/*
 * Programadora: Rebeca Divina Paula
 */
appDesafio.controller("loginOperador",  function($scope,$http,$location){
	$scope.autenticar = autenticar;
	
	$scope.usuario = {};
	$scope.token = "";
	$scope.mensagem = "";
	
	function autenticar(){
		 $http.post('http://localhost:8080/autenticar', $scope.usuario)
         .then(function (response) {
        	 $scope.mensagem = "";
        	 $scope.token = response.data.token;
        	 localStorage.setItem("userToken", response.data.token);
        	 
        	 if($scope.usuario.login == "admin"){
        		 $location.url("/operadores");
        	 }else{
        		 $http.get('http://localhost:8080/admin/operadorPorLogin/' + $scope.usuario.login)
                 .then(function (response) {
         			$scope.operador = response.data;
         			if($scope.operador.perfil === 'GERENTE'){
         				$location.url("/gerente");
         			}else{
         				$location.url("/analista");
         			}
                 })
                 .catch(function (response) {
                	 $scope.mensagem = response.data.message;
                 });

        	 }
        	 
         })
         .catch(function (response) {
        	 $scope.mensagem = response.data.message;
         });
	}
	
});