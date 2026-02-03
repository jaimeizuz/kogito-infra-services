param($kind,$artifactid);

$archetype_version="9.3.1-SNAPSHOT"

if ($kind -ne "bpmn" -and $kind -ne "dmn") {
    Write-Error "First argument has to be either 'bpmn' or 'dmn', but it's $kind";
    exit 1;
}

$groupid = "org.bamoe.test";

if ($null -eq $artifactid) {
    $artifactid = "bamoe-$kind-app";
}

Write-Output "Creating BAMOE $kind app from archetype with groupId = $groupid and artifactId = $artifactid...";

mvn archetype:generate -B `
    "-DarchetypeGroupId=org.jaime.bamoe" `
    "-DarchetypeArtifactId=bamoe-$kind-app-archetype" `
    "-DarchetypeVersion=$archetype_version" `
    "-DgroupId=$groupid" `
    "-DartifactId=$artifactid" `
    "-Dversion=1.0.0-SNAPSHOT"