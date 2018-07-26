from django.db import models

# all of these are subclasses of django.db.models.Model
class Question(models.Model):
    # contains a String question
    question_text = models.CharField(max_length=200)
    # save the publication date
    pub_date = models.DateTimeField('date published')

    def __str__(self):
        return self.question_text
    

class Choice(models.Model):
    # contains a Question to answer, can be accessed both ways due to ForeignKey
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    # contains a String answer
    choice_text = models.CharField(max_length=40)
    # contains an Integer number of votes, default 0
    votes = models.IntegerField(default=0)

    def __str__(self):
        return self.choice_text + str(self.votes)
