(function() {
    'use strict';

    angular
        .module('app.files')
        .factory('FilesService', FilesService);

    FilesService.$inject = ['$http'];
    /* @ngInject */
    function FilesService($http) {

        var host = 'http://pakonatsrv.mooo.com:8080/';
        host = 'http://localhost:8080/';
        var endpoint = 'mediacenter/files/';

        return {
            find: find,
            save: save,
            discard: discard
        };

        function find(status) {

            var uri = host + endpoint;
            if (status) {
                uri += '?status=' + status;
            }

            return $http.get(uri)
                .then(function(response) {
                    return response.data;
                });
        }

        function save(item) {
            return $http.put(host + endpoint + item.id, {
                status: 'DOWNLOAD'
            });
        }

        function discard(item) {
            return $http.put(host + endpoint + item.id, {
                status: 'DISCARD'
            });
        }
    }
})();
