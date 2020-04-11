var appDesafio = angular.module("appDesafio",['ngRoute'])


appDesafio.config(function($routeProvider){
	$routeProvider
	.when("/operadores",
		{templateUrl:'view/crud-operador.html', controller: 'cadastroOperador',
		 resolve:{
		        "check":function($location,$http){
		        	console.log('Testetetaetaetaetasdasdas')
		        	$http.get('http://localhost:8080/usuario/admin/')
		            .then(function (response){})
		            .catch(function () {
		            	 $location.path('/');
		            });
		        }
		    }
	})
	.when("/login",{templateUrl:'view/login.html', controller: 'loginOperador'})
	.otherwise({rediretTo:'/'});
});
