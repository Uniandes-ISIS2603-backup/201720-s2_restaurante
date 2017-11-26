/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
var mod = ng.module("clienteModule", ['ui.router']); //declaracion del modulo, llamo la funcion de angular ng, el nombre del modulo y las dependencias
    mod.constant("clientesContext", "http://localhost:8080/restaurante-web/api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) 
        {
            var basePath = 'src/modules/clientes/';
            $urlRouterProvider.otherwise("/clientesList");

        /*
         * Vista principal modulo clientes
         * Definicion estado abstracto
         */    
        $stateProvider.state('clientes', {
                url: '/clientes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.html',
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                /*
                 * Vista de la lista de clientes
                 */
            }).state('clientesList', {
                url: '/list',
                parent: 'clientes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html'
                    }
                }
                /*
                 * Vista del detalle de un cliente con un id especificado por parametro
                 * Param: clienteId
                 */
            }).state('clientesDetail', {
                url: '/{clienteId:int}/detail',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'clientes.detail.html',
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl'
                    }

                }
            /*
             * Vista de creacion de un nuevo cliente
             */
            }).state('clienteCreate', {
                url: '/create',
                parent: 'clientes',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/clientes.new.html',
                        controller: 'clienteNewCtrl'
                    }
                },
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
                /*
                 * Vista de modificar un cliente con un id especificado por parametro
                 * Param: clienteId
                 */
            }).state('clienteUpdate', {
                url: '/update/{clienteId:int}',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/clientes.new.html',
                        controller: 'clienteUpdateCtrl'
                    }
                },
                data: {
                    requireLogin: true,
                    roles: ['admin', 'assistant']
                }
                /*
                 * Vista para eliminar un cliente con un id especificado por parametro
                 * Param: clienteId
                 */
            }).state('clienteDelete', {
                url: '/delete/{clienteId:int}',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/clientes.delete.html',
                        controller: 'clienteDeleteCtrl'
                    }
                },
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            });
        }]);

})(window.angular);
