appDesafio.controller("loginOperador",  function($scope,$http){
	$scope.autenticar = autenticar;
	
	$scope.usuario = {};
	$scope.token = "";
	
	function autenticar(){
		 $http.post('http://localhost:8080/autenticar', $scope.usuario)
         .then(function (response) {
        	 $scope.token = response.data.token;
        	 localStorage.setItem("userToken", response.data.token);
         })
         .catch(function () {
        	 console.log(response.data);
         });
	}
	
});