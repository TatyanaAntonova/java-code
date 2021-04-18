
public class Main {
    public static void main(String[] args) {
        Jewels j = new Jewels();
        String jewels = "aAb";
        String stones = "caсAcA";
        System.out.println(j.numJewelsInStones(jewels, stones));

        Main j2 = new Main();
        System.out.println(j2.numJewelsInStones2(jewels, stones));
    }

    public int numJewelsInStones2(String jewels, String stones){
        char[] jewelsArray = jewels.toCharArray();
        char[] stonesArray = stones.toCharArray();

        int count = 0;
        for(char jewelsExamle : jewelsArray){
            for (char stonesExample : stonesArray)
                if(jewelsExamle == stonesExample){
                    count++;
                }
        }
        return count;
    }
}
