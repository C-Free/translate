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
int GhiFile(char* filename,TuDien x);
void DocFile(char* filename,TuDien x);
int HF(int x);
void Init();
int EmptyBucket(int k);
int LayChuoiDau(char *h);
bool KiemTraChuoi(char *h);
bool Them(TuDien y);
void Xuat();
void Nhap();
void Menu();
int main(int argc, char *argv[]){
	TuDien x;
	Init();
	DocFile("E:/translate.txt",x);
	char password[15];
	int chon=-1;
	char h[15];
	DocFile("E:/translate.txt",x);
	while(chon!=3){
			Menu();
			scanf("%d",&chon);
		switch(chon){
			case 1:
				printf("nhap password:");
				fflush(stdin);
				gets(password);
				if(strcmp(password,"123")==0){	
					Nhap();
				}
				break;
			case 2:
				printf("nhap chu can tim:");
				fflush(stdin);
				scanf("%s",&h);
				if(KiemTraChuoi(h)==true){
					printf("tim thay\n");
				}else{
					printf("khong tim thay\n");
				}
				break;
			default:
				break;
		}
	}
}
int GhiFile(char* filename,TuDien x){
	FILE* f=fopen(filename,"w");
	if(!f)
		return 0;
	for(int i=0;i<M;i++){
		if(bucket[i]!=NULL){
			PhanTu *p;
			p=bucket[i];
			while(p!=NULL){
				fprintf(f,"%s\n",p->x.TiengAnh);
				p=p->link;
			}
		}
	}
	fclose(f);
	return 1;
}
void DocFile(char* filename,TuDien x){
	FILE* f=fopen(filename,"r");
	if(!f)
		printf("mo file khong thanh cong\n");
	int i=0;
	PhanTu *p;
	while(!feof(f)){
		fscanf(f,"%s",x.TiengAnh);
		Them(x);
	}
}
//read from file
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
				printf("Tieng anh:%s\n",p->x.TiengAnh);
				p=p->link;
			}
		}
	}
}
//nhap
void Nhap(){
	bool flag=true;
	TuDien x;
	char h[100];

//	int soLuong=0;
	while(flag!=false){
		char h[15];
		printf("Nhap Tieng Anh:");
		fflush(stdin);
		scanf("%s",&h);
		char* p = strtok(h, " ");
   		int i=0;
  	 	char str1[5][15];
  	 	while(p!='\0'){	/* duyet qua cac token con lai */
   			strcpy(str1[i],p);
   			i++;
   			p=strtok('\0'," ");
   		}
  	 	x.TiengAnh=str1[0];
		if(strcmp(x.TiengAnh,"ahihi")==0){
			flag=false;
		}else{
				Them(x);
		}
	}
	GhiFile("E:/translate.txt",x);
}
//menu
void Menu(){
	printf("1.nhap tu dien\n");
	printf("2.tim kiem tu\n");
	printf("3.thoat\n");
}
