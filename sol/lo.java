class Solution {
   public int lastStoneWeight(int[] stones)
{
		ArrayList<Integer> listStones = new ArrayList<>();
		for (int a : stones)
			listStones.add(a);

		while (true)
		{
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int len = listStones.size();

			if (len == 1 || len == 0)
			{
				break;
			}

			Collections.sort(listStones);
			min = listStones.get(len - 2);
			max = listStones.get(len - 1);

			if (min < max)
			{
				max = max - min;
				listStones.remove(listStones.size()-1);
				listStones.remove(listStones.size()-1);
				listStones.add(max);

			}
			else if (min == max)
			{
				listStones.remove(listStones.size()-1);
				listStones.remove(listStones.size()-1);
			}
		}
		
        if(listStones.size()==1)
            return listStones.get(0);
        return 0;
	}
}
