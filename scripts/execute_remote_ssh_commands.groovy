@Grab('org.hidetake:groovy-ssh:2.0.0')
@GrabExclude('org.codehaus.groovy:groovy-all')

// servei
def ssh = org.hidetake.groovy.ssh.Ssh.newService()

ssh.settings {
     knownHosts = allowAnyHosts
}

// les configuracions han d'estar sempre dins de la closure 'remotes'
// aix� �s per convenci� (igual q host user i password) els altres
// noms s�n uptoyou frontaldev... frontalback... myserver...
ssh.remotes {
    frontaldev {
      host = 'XXXXXXXXX'
      user = 'userName'
      password = 'password'
    }
}


// groovy dsl style... aix� ja t'ho explicar�
ssh.run {
    session(ssh.remotes.frontaldev) {
        // i llestos... amb strings a fer comandes! :P
        def result = execute('ls -la')
        println result
                
    }
}