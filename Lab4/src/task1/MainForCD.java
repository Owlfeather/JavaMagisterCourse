package task1;

public class MainForCD {

    public static void main(String[] args) {

        CD disk = new CD("CD 2.0");
        CD.Directory dir = disk.new Directory();

        Component folder1 = new Component(1, "Folder 1", false, 3, 0 );
        Component folder2 = new Component(2, "Folder 2",false, 3, 0 );
        Component folder3 = new Component(3, "Folder 3",false, 3, 0 );

        dir.addComponent(folder1);
        dir.addComponent(folder2);
        dir.addComponent(folder3, folder2);

        Component file1 = new Component(4, "Queen - We are the Champions",true, 1500, 190 );
        Component file2 = new Component(5, "Imagine Dragons - Believer",true, 1800, 120 );
        Component file3 = new Component(6, "Nickelback - She keeps me up",true, 900, 50 );
        Component file4 = new Component(7, "Kipelov - Ya svoboden",true, 1700, 160 );
        Component file5 = new Component(8, "Alisa - Moyo pokolenie",true, 2100, 210 );

        dir.addComponent(file1);
        dir.addComponent(file2, folder1);
        dir.addComponent(file3, folder1);
        dir.addComponent(file4, folder2);
        dir.addComponent(file5, folder2);

        System.out.println(dir);


    }
}
