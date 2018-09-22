#include <stdio.h>
#include <stdlib.h>
#include <string.h>
const int M=100;
struct TuDien{
	char TiengAnh[15];
};
typedef struct Node{
	struct TuDien x;
	struct Node *link;
};
typedef struct Node PhanTu;//DInh nghia
PhanTu *bucket[M];
//de lay so M
int HF(int x){
	return (x%M);
}
//lam danh sach rong
void Init(){
	for(int i=0;i<M;i++){
		bucket[i]=NULL;
	}
}
//kiem tra danh sach rong
int EmptyBucket(int k){
	int i=HF(k);
	return bucket[i]==NULL?1:0;
}
//chuyen doi chuoi thanh so ->check
int LayChuoiDau(char *h){
	int so=h[0];
	return so;
}
//kiem tra chuoi             ->check
bool KiemTraChuoi(char *h){
	int i=HF(LayChuoiDau(h));
	PhanTu *p;
	p=bucket[i];
	while(p!=NULL){
		if(strcmp(p->x.TiengAnh,h)==0){
			return true;//tim thay
		}
		p=p->link;
	}
	return false;//neu khong thay
}
//Them
bool Them(TuDien y){
	
	if(KiemTraChuoi(y.TiengAnh)==false){
		int i=HF(LayChuoiDau(y.TiengAnh));
			//if(EmptyBucket(i)==1){
				//bucket[i]->x=y;
				//bucket[i]->link=NULL;
			//	return true;	
			//}else{
				PhanTu *p=(PhanTu *)malloc(sizeof(PhanTu));//cap phat
				p->x=y;
				p->link=bucket[i];
				bucket[i]=p;	
				return true;
			
		//	PhanTu *p;
		//p=bucket[i];
		//p->link=bucket[i];
		//p->x=y;
		//bucket[i]=p;
		return true;
	}else{
		//tra ve false neu co trong bang bam
		return false;
	}
}
//xuat
void Xuat(){
	PhanTu *p;
	for(int i=0;i<M;i++){
		if(bucket[i]!=NULL){
			p=bucket[i];
			while(p!=NULL){
				printf("%s\n",p->x.TiengAnh);
				p=p->link;
			}
		}
	}
}
int main(int argc, char *argv[]){
	TuDien x;
	char h[100];
	Init();
	while(*h!='o'){
		printf("nhap chu:");
		fflush(stdin);
		gets(x.TiengAnh);
		if(Them(x)==true){
			Xuat();	
		}else{
			printf("trung\n");
		};
		
	}

	
}
