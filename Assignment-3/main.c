#include <stdio.h>
#include <omp.h>

int main() {

    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int N = 10;
    int n = 3;
    int chunk = N / n;
    int sum = 0;

    #pragma omp parellel num_threads(n)
    {
        int thread_id = omp_get_thread_num();
        int start = thread_id * chunk;
        int end = start + chunk;
        int local_sum = 0;

        for(int i=start; i<end; i++){
            local_sum += arr[i];
        }
        printf("Local Sum of thread%d is : %d", thread_id, local_sum);
        #pragma omp critical
        {
            sum += local_sum;
        }
    } 

    printf("Total Sum is : %d", sum);

    return 0;
}