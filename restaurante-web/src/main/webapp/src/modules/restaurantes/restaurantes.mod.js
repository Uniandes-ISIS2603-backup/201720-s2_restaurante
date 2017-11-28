/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("restauranteModule", ['ui.router']); //declaracion del modulo, llamo la funcion de angular ng, el nombre del modulo y las dependencias
    mod.constant("restaurantesContext", "api/sucursales");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/restaurantes/';
            $urlRouterProvider.otherwise("/restaurantesList");

            /*
            * Vista principal modulo restaurante
            * Definicion estado abstracto
            */
            $stateProvider.state('restaurantes', {
                url: '/restaurantes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'restaurantes.html',
                        controller: 'restauranteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                ,
                data: {
                    requireLogin: false,
                    roles: ['admin', 'assistant']
                }
                /*
                 * Vista de la lista de restaurantes
                 */
            }).state('restaurantesList', {
                url: '/list',
                parent: 'restaurantes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'restaurantes.list.html'
                    }
                }
                /*
                 * Vista del detalle de un restaurante con un id especificado por parametro
                 * Param: restauranteId
                 */
            }).state('restauranteDetail', {
                url: '/{restauranteId:int}/detail',
                parent: 'restaurantes',
                param: {
                    restauranteId: null
                },
                views: {
                    'listView': {
                       templateUrl: basePath + 'restaurantes.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'restaurantes.detail.html',
                        controller: 'restauranteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
             /*
             * Vista de creacion de un nuevo restaurante
             */
            }).state('restaurantesCreate', {
                url: '/create',
                parent: 'restaurantes',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/restaurantes.new.html',
                        controller: 'restauranteNewCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
                /*
                 * Vista de modificar un restaurante con un id especificado por parametro
                 * Param: restauranteId
                 */
            }).state('restauranteUpdate', {
                url: '/update/{restauranteId:int}',
                parent: 'restaurantes',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/restaurantes.new.html',
                        controller: 'restauranteUpdateCtrl'
                    }
                }
                 /*
                 * Vista para eliminar un restaurante con un id especificado por parametro
                 * Param: restauranteId
                 */
            }).state('restauranteDelete', {
                url: '/delete/{restauranteId:int}',
                parent: 'restaurantes',
                param: {
                    restauranteId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/restaurante.delete.html',
                        controller: 'restauranteDeleteCtrl'
                    }
                }
            });
        }]);
})(window.angular);
