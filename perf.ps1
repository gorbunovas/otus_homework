for ($x=0 ;$x -le 30;$x=$x+1){

$headers = New-Object "System.Collections.Generic.Dictionary[[String],[String]]"
$headers.Add("Content-Type", "application/json")

$body = "{
`n  `"userName`": `"johndoe$x`",
`n  `"firstName`": `"John`",
`n  `"lastName`": `"Doe`",
`n  `"email`": `"bestjohn@doe.com`",
`n  `"phone`": `"+71002003040`"
`n}"

$response = Invoke-RestMethod 'http://arch.homework/otusapp/gorbunovas/user' -Method 'POST' -Headers $headers -Body $body
$response | ConvertTo-Json



}