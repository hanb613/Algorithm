class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int sumD=0, sumP=0;
        for(int i=0; i<n; i++){
            sumD+=deliveries[i];
            sumP+=pickups[i];
        }


        int idxD=n-1, idxP=n-1;        
        while(sumD>0 || sumP>0) {
            int deliver=cap, pickup = cap;
            int idx = -1;

            // 배달
            for(int i=idxD; i>=0; i--){
                if(deliveries[i]>0){
                    idx = Math.max(idx, i);
                    
                    if(deliveries[i]>deliver){
                        deliveries[i]-=deliver;
                        sumD-=deliver;
                        idxD=i; 
                        break;
                    } else {
                        deliver-=deliveries[i];
                        sumD-=deliveries[i];
                        deliveries[i]=0;
                    }
                }
            }
            
            // 수거
            for(int i=idxP; i>=0; i--){
                if(pickups[i]>0){
                    idx = Math.max(idx, i);
                    
                    if(pickups[i]>pickup){
                        pickups[i]-=pickup;
                        sumP-=pickup;
                        idxP=i; 
                        break;
                    } else {
                        pickup-=pickups[i];
                        sumP-=pickups[i];
                        pickups[i]=0;
                    }
                }
            }
            
            if(idx>=0){
                answer+=((idx+1)*2);
            }
        }

        return answer;
    }

}