/*
 * Programadora: Rebeca Divina Paula
 */
var appDesafio = angular.module("appDesafio",['ngRoute','ui.mask'])


appDesafio.config(function($routeProvider){
	$routeProvider
	.when("/operadores",
		{templateUrl:'view/crud-operador.html', controller: 'cadastroOperador',
		 resolve:{
		        "check":function($location,$http){
		        	$http.get('http://localhost:8080/usuario/admin/')
		            .then(function (response){})
		            .catch(function () {
		            	 $location.path('/');
		            });
		        }
		    }
	})
	.when("/login",{templateUrl:'view/login.html', controller: 'loginOperador'})
	.when("/gerente",{templateUrl:'view/visao-gerente.html', controller: 'cadastropessoa'})
	.when("/analista",{templateUrl:'view/visao-analista.html', controller: 'analistaController'})
	.when("/logout",{templateUrl:'view/login.html'})
	.otherwise({rediretTo:'/'});
});
