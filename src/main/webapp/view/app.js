var app = angular.module('app',[]);

app.controller('EmployeeCtrl', ['$scope','EmployeeService', function ($scope,EmployeeService) {

    $scope.displayHierarchy = function (employeeId, managerId) {
        EmployeeService.showHierarchy(employeeId)
            .then(function success(response){
                    $scope.employeehierarchy = response.data._embedded.employees;

                    $scope.managerId = managerId;
                    $scope.hierarchyData = $scope.buildHierarchy($scope.employeehierarchy);

                    $scope.message='';
                    $scope.errorMessage = '';
                },
                function error (response ){
                    $scope.message='';
                    $scope.errorMessage = 'Error getting employees!';
                });
    }

    $scope.getAllEmployees = function () {
        EmployeeService.getAllEmployees()
            .then(function success(response){
                    $scope.employees = response.data._embedded.employees;
                    $scope.message='';
                    $scope.errorMessage = '';
                },
                function error (response ){
                    $scope.message='';
                    $scope.errorMessage = 'Error getting employees!';
                });
    }

    $scope.buildHierarchy = function buildHierarchy(array,parent, tree) {

        tree = typeof tree !== 'undefined' ? tree : [];
        parent = typeof parent !== 'undefined' ? parent : { employeeId: $scope.managerId };

        var children = _.filter( array, function(child){ return child.managerId == parent.employeeId; });

        if( !_.isEmpty( children )  ){
            if( parent.employeeId == $scope.managerId ){
                tree = children;
            }else{
                parent['children'] = children;
            }
            _.each( children, function( child ){ buildHierarchy( array, child ) } );
        }

        return tree;
    }

}]);

app.service('EmployeeService',['$http', function ($http) {

    this.showHierarchy = function (employeeId) {
        return $http({
            method: 'GET',
            url: 'employees/search/showHierarchy?employeeId='+employeeId
        })
    }

    this.getAllEmployees = function getAllUsers(){
        return $http({
            method: 'GET',
            url: 'employees'
        });
    }

}]);