def compute(centroid, data):
    from scipy.spatial.distance import euclidean
    result = []
    for i in data:
        f_res = 0
        res = euclidean(i, centroid[0])
        res2 = euclidean(i, centroid[1])
        res3 = euclidean(i, centroid[2])
        if res > res2:
            f_res = 1
        if res > res3:
            f_res = 2
        result.append(f_res)
    return result

def chunks(l, n):
    if n < 1:
        n = 1
    return [l[i:i + n] for i in range(0, len(l), n)]

if __name__ == '__main__':
    import dispy, numpy as np, cPickle as pickle
    f = open('kddcup.newtestdata_10_percent_unlabeled.csv','rb')
    c = open('centroid','rb')
    r = open('result','wb')
    contents = map(str.strip, f.readlines())
    data = []
    for i in contents:
        x = map(float, i.split(','))
        data.append(x)
    data = np.array(data)
    print len(data)
    data_chunks = chunks(data, 3111)
    cluster = dispy.JobCluster(compute, nodes=['192.168.137.63','192.168.137.202','192.168.137.116','192.168.137.70'])
    jobs = []
    c = pickle.load(c)
    result = []
    for i in range(100):
        job = cluster.submit(c, data_chunks[i])
        job.id = i
        jobs.append(job)
    for job in jobs:
        job()
        print('Job %s finished' % (job.id+1))
        result.extend(job.result)
    for i in result:
      r.write("%s\n" % i)
