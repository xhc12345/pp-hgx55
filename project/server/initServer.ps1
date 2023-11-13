Write-Output "this script is located at $PSScriptRoot"  # echo
Set-Location $PSScriptRoot  # cd

go mod tidy
$d = "web-service-gin"  # set variable `d`
go run $d/main.go $d/routes.go $d/database_shell.go $d/database_pkge.go $d/models.go

Write-Output "Server down"  # echo