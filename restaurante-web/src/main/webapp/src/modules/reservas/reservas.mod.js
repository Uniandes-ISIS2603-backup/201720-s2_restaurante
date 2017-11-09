(function (ng){
    var mod = ng.module("reservaModule",['ui.router']);
    mod.constant("reservasContext", "api/reservas");
    mod.config(['$stateProvider','$urlRouterProvider', function($stateProvider,$urlRouterProvider){
            var basePath='src/modules/reservas/';
            $urlRouterProvider.otherwise("/reservasList");
            
            $stateProvider.state('reservas', {
                url: '/reservas',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'reservas.html',
                        controller: 'reservasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('reservasList', {
                url: '/list',
                parent: 'reservas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'reservas.list.html'
                    }
                }
            }).state('reservaDetail', {
                url: '/{reservaId:int}/detail',
                parent: 'reservas',
                param: {
                    reservaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'reservas.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'reservas.detail.html',
                        controller: 'reservasCtrl',
                        controllerAs: 'ctrl'
                    }

                }

            }).state('reservasCreate', {
                url: '/create',
                parent: 'reservas',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/reservas.new.html',
                        controller: 'reservaNewCtrl'
                    }
                }
            }).state('reservaUpdate', {
                url: '/update/{reservaId:int}',
                parent: 'reservas',
                param: {
                    reservaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/reservas.new.html',
                        controller: 'reservaUpdateCtrl'
                    }
                }
            })
                    .state('reservaDelete', {
                url: '/delete/{reservaId:int}',
                parent: 'reservas',
                param: {
                    reservaId: null
                },
                views: {
                    'detailView': {
                       templateUrl: basePath + '/delete/reserva.delete.html',
                        controller: 'reservaDeleteCtrl'
                    }
                }
            })
            ;
    }]);
})(window.angular);