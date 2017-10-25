/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
var mod = ng.module("clienteModule", ['ui.router']); //declaracion del modulo, llamo la funcion de angular ng, el nombre del modulo y las dependencias
    mod.constant("clientesContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', 
        function ($stateProvider, $urlRouterProvider) 
        {
            var basePath = 'src/modules/cliente/';
            $urlRouterProvider.otherwise("/clientesList");

            $stateProvider.state('clientesList', 
            {
                url: '/clientes/list',
                views: {
                    'mainView': {
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'clientes.list.html'
                    }
                }
            }
                    ).state('clientesCreate', 
            {
                url: '/clientes/create',
                views: {
                    'mainView': {
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'clientes.create.html'
                    }
                }

            }
                    ).state('clientesEdit', 
            {
                url: '/clientes/:clientesId',
                param: 
                        {
                    clientesId: null
                },
                views: {
                    'mainView': {
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'clientes.create.html'
                    }
                }
            });
        }]);

})(window.angular);



