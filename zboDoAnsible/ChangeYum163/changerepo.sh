ansible vagrant -i ../hosts -m shell -a "rm -rf /home/vagrant/163.repo" -s
ansible vagrant -i ../hosts -m shell -a "mkdir /home/vagrant/163.repo"
ansible vagrant -i ../hosts -m copy -a "src=./CentOS-Base-163.repo dest=/home/vagrant/163.repo"
ansible vagrant -i ../hosts -m shell -a "cp /home/vagrant/163.repo/CentOS-Base-163.repo . && cd ~" -s
#ansible vagrant -i ../hosts -m shell -a "yum makecache"


