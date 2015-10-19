(function(){
    angular.module('boulimiqueLitteraire').factory('UserFactory', ['$http', function ($http) {

        var urlBase = '/api/users';
        var factory = {};

        factory.getAll = function () {
            return $http.get(urlBase)
            .then(function (results){
                return results.data;
            });
        };

        factory.getById = function (id) {
            return $http.get(urlBase + '/' + id).
                then(function (result){
                    return result.data;
                }
            );
        }

        factory.save = function (user) {
            return $http.post(urlBase, user).
                then(function(response) {
                    return response.data;
                }
            );
        }

        factory.update = function (user) {
            return $http.put(urlBase + '/' + user.id, user).
                then(function(response) {
                    return response.data;
                }
            );
        }

        factory.remove = function (id) {
            return $http.delete(urlBase + '/' + id);
        }

        return factory;
    }]);
}());