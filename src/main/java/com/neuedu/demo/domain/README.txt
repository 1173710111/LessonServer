publishedTime:
String���ͣ������Ժ���Ϊ��λ��long�����֣���ʾ��1970-1-1 00:00:00 UTC���������ַ�������ʾ���ڵĺ�����

//0-unfinished 1-right 2-wrong
	private int finishedState;
	//0-unstared 1-stared
	private int starState;

Activity.type:
��homework�� ��activity��

ActivityFile.type:
��downFile�� ����ʦ�ϴ��ĸ���
��upFile����ѧ���ϴ����ļ�

UserInfo.type:
��student��  ��teacher�� 

Message.type:
��1����activityToast��:��ύ��ʾ��ģ�壺��ͬѧ������һ��[�i��xxxxxxxx]����ɣ�hh:mm:ss��ֹ���뾡����ɡ���
��2����memberDeleteToast�����Ƴ��γ���ʾ��ģ�壺�����ѱ��Ƴ��γ̡�xxx������
��3����teamAddToast��������������ʾ��ģ�壺���û�[aaa]�������������Ķ��飬��ͬ��ɻ[�i:xxxxxxx]���Ƿ�ͬ����룿��+����button���ǡ��͡���
��4����myReply����
ģ�壺���ڡ�xxx���γ̵���������yyyyyy���е����ۡ�zzzzzzzz����һ���»ظ���\n@bbb��aaaaaaaaaa
��5����myDiscussion����
ģ�壺���ڡ�xxx���γ̷�������������yyyyyy������һ�������ۣ�\n@bbb��aaaaaaaaaa
