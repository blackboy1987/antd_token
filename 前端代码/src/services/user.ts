import request from '@/utils/request';

export async function query(): Promise<any> {
  return request('/api/users');
}

export async function queryCurrent(): Promise<any> {
  return request('http://localhost:8080/api/currentUser');
}

export async function queryNotices(): Promise<any> {
  return request('/api/notices');
}
